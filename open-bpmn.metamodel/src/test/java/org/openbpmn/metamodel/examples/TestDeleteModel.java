package org.openbpmn.metamodel.examples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openbpmn.bpmn.BPMNModel;
import org.openbpmn.bpmn.BPMNTypes;
import org.openbpmn.bpmn.elements.BPMNActivity;
import org.openbpmn.bpmn.elements.BPMNParticipant;
import org.openbpmn.bpmn.elements.BPMNProcess;
import org.openbpmn.bpmn.exceptions.BPMNModelException;
import org.openbpmn.bpmn.util.BPMNModelFactory;

/**
 * This test class tests the deletion of BPMN Model elements
 * 
 * @author rsoika
 *
 */
public class TestDeleteModel {

    private static Logger logger = Logger.getLogger(TestDeleteModel.class.getName());

    static BPMNModel model = null;

    @BeforeAll
    public static void init() throws BPMNModelException {
        logger.info("...read model");
        model = BPMNModelFactory.read("/refmodel-1.bpmn");

    }

    /**
     * This test creates a bpmn file
     */
    @Test
    public void testDeleteTask() {
        String out = "src/test/resources/delete-process_1.bpmn";
        try {
            BPMNModel model = BPMNModelFactory.read("/refmodel-1.bpmn");
            BPMNProcess process = model.openProcess(null);
            process.deleteTask("Task_1");
        } catch (BPMNModelException e) {
            e.printStackTrace();
            fail();
        }
        model.save(out);
        logger.info("...model update sucessful: " + out);
    }

    /**
     * This test creates a bpmn file
     */
    @Test
    public void testDeleteTaskAndStartEvent() {
        String out = "src/test/resources/delete-process_2.bpmn";
        try {
            BPMNModel model = BPMNModelFactory.read("/refmodel-1.bpmn");

            BPMNProcess process = model.openProcess(null);
            process.deleteTask("Task_1");
            process.deleteEvent("StartEvent_1");
        } catch (BPMNModelException e) {
            e.printStackTrace();
            fail();
        }
        model.save(out);
        logger.info("...model update sucessful: " + out);
    }

    /**
     * This test build new model and delete element
     */
    @Test
    public void testBuildAndDelete() {

        String exporter = "demo";
        String version = "1.0.0";
        String targetNameSpace = "http://org.openbpmn";
        try {
            BPMNModel model = BPMNModelFactory.createInstance(exporter, version, targetNameSpace);
            BPMNProcess processContext = model.openDefaultProcess();
            assertNotNull(processContext);

            // add a start and end event
            processContext.addEvent("start_1", "Start", BPMNTypes.START_EVENT);
            processContext.addEvent("end_1", "End", BPMNTypes.END_EVENT);
            BPMNActivity task = processContext.addTask("task_1", "Task", BPMNTypes.TASK);
            task.getBounds().setPosition(10.0, 10.0);
            task.getBounds().setDimension(140.0, 60.0);

            processContext.addSequenceFlow("SequenceFlow_1", "start_1", "task_1");
            processContext.addSequenceFlow("SequenceFlow_2", "task_1", "end_1");
            processContext.deleteTask("task_1");
        } catch (BPMNModelException e) {
            e.printStackTrace();
            fail();
        }

    }

    /**
     * This test build new model one participant and a task. The test delete
     * participant - we expect the task is also deleted, but we still have a default
     * process and a collaboration diagram.
     */
    @Test
    public void testDeleteParticipant() {

        String exporter = "demo";
        String version = "1.0.0";
        String targetNameSpace = "http://org.openbpmn";
        try {
            BPMNModel model = BPMNModelFactory.createInstance(exporter, version, targetNameSpace);
            BPMNProcess defaultProcess = model.openDefaultProcess();
            assertNotNull(defaultProcess);

            // create Participant
            BPMNParticipant sales = model.addParticipant("Sales");

            // add Task
            BPMNProcess privateProcess = sales.openProcess();
            // add a start and end event
            privateProcess.addEvent("start_1", "Start", BPMNTypes.START_EVENT);
            privateProcess.addEvent("end_1", "End", BPMNTypes.END_EVENT);
            privateProcess.addTask("task_1", "Task", BPMNTypes.TASK);
            privateProcess.addSequenceFlow("SequenceFlow_1", "start_1", "task_1");
            privateProcess.addSequenceFlow("SequenceFlow_2", "task_1", "end_1");

            // we expect 3 Flow elements and 2 Processes
            assertEquals(3, privateProcess.getBPMNFlowElements().size());
            assertEquals(2, model.getProcesses().size());
            assertEquals(2, model.getParticipants().size());

            // now delete the Participant
            model.deleteBPMNParticipant(sales);
            assertEquals(1, model.getParticipants().size());
            assertEquals(1, model.getProcesses().size());

        } catch (BPMNModelException e) {
            e.printStackTrace();
            fail();
        }

    }

}
