package ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import model.EventLog;
import model.Event;

// Window Adapter
public class MyWindowAdapter extends WindowAdapter {

    // EFFECTS: calls printEventLog method when application is closed
    @Override
    public void windowClosing(WindowEvent e) {
        printEventLog(EventLog.getInstance());
    }

    // EFFECTS: prints event log to console
    public void printEventLog(EventLog el) {
        for (Event e : el) {
            System.out.println(e);
        }
    }

}
