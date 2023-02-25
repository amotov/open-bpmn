package org.openbpmn.bpmn.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openbpmn.bpmn.BPMNModel;
import org.openbpmn.bpmn.exceptions.BPMNModelException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 * The BPMNModelFactory can be used to load or create a BPMNModel instance.
 * 
 * @author rsoika
 *
 */
public class BPMNModelFactory {
    private static Logger logger = Logger.getLogger(BPMNModelFactory.class.getName());

    public static final String DEFAULT_EXPORTER = "org.openbpmn";
    public static final String DEFAULT_VERSION = "1.0.0";
    public static final String DEFAULT_TARGETNAMESPACE = "http://org.openbpmn";

    /**
     * This method creates a new empty BPMNModel instance. The BPMNModel is
     * initialized with the BPMN default namespaces.
     * 
     * @param exporter
     * @param exporterVersion
     * @param targetNamespace
     * @return
     */
    public static BPMNModel createInstance(String exporter, String exporterVersion, String targetNamespace) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setNamespaceAware(true);
        DocumentBuilder docBuilder;
        try {
            docBuilder = docFactory.newDocumentBuilder();

            /*
             * <bpmn2:definitions xmlns:bpmn2="http://www.omg.org/spec/BPMN/20100524/MODEL"
             * xmlns:bpmndi="http://www.omg.org/spec/BPMN/20100524/DI"
             * xmlns:dc="http://www.omg.org/spec/DD/20100524/DC"
             * xmlns:di="http://www.omg.org/spec/DD/20100524/DI"
             * xmlns:ext="http://org.eclipse.bpmn2/ext"
             * xmlns:xs="http://www.w3.org/2001/XMLSchema"
             * xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             * exporter="org.eclipse.bpmn2.modeler.core"
             * exporterVersion="1.5.3.Final-v20210519-2007-B1" id="Definitions_1"
             * targetNamespace="http://org.eclipse.bpmn2/default/process">
             */
            // root elements
            Document doc = docBuilder.newDocument();
            Element definitions = doc.createElementNS("http://www.omg.org/spec/BPMN/20100524/MODEL",
                    "bpmn2:definitions");

            // set BPMN default namespaces
            definitions.setAttribute("xmlns:bpmndi", "http://www.omg.org/spec/BPMN/20100524/DI");
            definitions.setAttribute("xmlns:di", "http://www.omg.org/spec/DD/20100524/DI");
            definitions.setAttribute("xmlns:dc", "http://www.omg.org/spec/DD/20100524/DC");
            definitions.setAttribute("xmlns:xs", "http://www.w3.org/2001/XMLSchema");
            definitions.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");

            // set definitions attributes
            definitions.setAttribute("exporter", exporter);
            definitions.setAttribute("exporterVersion", exporterVersion);
            definitions.setAttribute("targetNamespace", targetNamespace);
            doc.appendChild(definitions);

            BPMNModel model = new BPMNModel(doc);

            // add an empty public default process
            // model.buildProcess("process_1", "Default Process",
            // BPMNTypes.PROCESS_TYPE_PUBLIC);

            return model;
        } catch (ParserConfigurationException | BPMNModelException e1) {

            e1.printStackTrace();
        }

        return null;
    }

    /**
     * Reads a BPMNModel instance from an java.io.File
     * 
     * @param modelFile
     * @return a BPMNModel instance
     * @throws BPMNModelException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static BPMNModel read(File modelFile) throws BPMNModelException {
        try {
            return read(new FileInputStream(modelFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Reads a BPMNModel instance from an given file path
     * 
     * @param modelFile
     * @return a BPMNModel instance
     * @throws BPMNModelException
     * @throws IOException
     */
    public static BPMNModel read(String modelFilePath) throws BPMNModelException {
        return read(BPMNModel.class.getResourceAsStream(modelFilePath));
    }

    /**
     * Reads a BPMNModel instance from an InputStream
     * 
     * @param modelFile
     * @return a BPMNModel instance
     * @throws BPMNModelException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static BPMNModel read(InputStream is) throws BPMNModelException {
        logger.fine("read from inputStream...");
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setIgnoringElementContentWhitespace(true); // because of a bug this does not have any effect!
        docFactory.setNamespaceAware(true);
        try {
            if (is.available() == 0) {
                logger.warning("Emtpy BPMN file - creating a default process");
                // create a default model
                BPMNModel defaultModel = BPMNModelFactory
                        .createInstance(DEFAULT_EXPORTER, DEFAULT_VERSION, DEFAULT_TARGETNAMESPACE);
                // add an empty public default process
                // defaultModel.buildProcess("process_1", "Default Process",
                // BPMNTypes.PROCESS_TYPE_PUBLIC);
                return defaultModel;
            }

            // parse XML file
            DocumentBuilder db = docFactory.newDocumentBuilder();
            // read from a project's resources folder
            Document doc = db.parse(is);
            Element root = doc.getDocumentElement();

            // explicit remove whitespace
            removeWhitespaceNodes(root);

            if (!"bpmn2:definitions".equals(root.getNodeName())
                    &&
                    !"bpmn:definitions".equals(root.getNodeName())) {
                logger.severe("Missing root element 'bpmn2:definitions'!");
                return null;
            } else {
                return new BPMNModel(doc);
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * Removes whitespace from an Element
     * <p>
     * This helper method is needed as the Dom XML parser does not remove
     * whitespaces despite the hint enabled.
     *
     * @see https://coderbyheart.com/jaxp-dom-whitespace-aus-xml-entfernen
     * @see http://forums.java.net/jive/thread.jspa?messageID=345459
     * @param e
     */
    private static void removeWhitespaceNodes(Element e) {
        NodeList children = e.getChildNodes();
        for (int i = children.getLength() - 1; i >= 0; i--) {
            Node child = children.item(i);
            if (child instanceof Text && ((Text) child).getData().trim().length() == 0) {
                e.removeChild(child);
            } else if (child instanceof Element) {
                removeWhitespaceNodes((Element) child);
            }
        }
    }
}
