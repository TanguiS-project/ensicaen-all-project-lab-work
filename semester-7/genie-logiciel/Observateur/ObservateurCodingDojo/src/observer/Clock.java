package observer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Clock extends Thread implements Observable {
    private Calendar _calendar;
    private String _time = "";
    private final List<Observer> _observer = new ArrayList<>();


    public Clock() {
    }

    @Override
    public void run() {
        while (true) {
            _calendar = Calendar.getInstance();
            _time = _calendar.get(Calendar.HOUR_OF_DAY) + " : "
                    +
                    (_calendar.get(Calendar.MINUTE) < 10
                            ? "0" + _calendar.get(Calendar.MINUTE)
                            : _calendar.get(Calendar.MINUTE))
                    + " : "
                    +
                    (_calendar.get(Calendar.SECOND) < 10
                            ? "0" + _calendar.get(Calendar.SECOND)
                            : _calendar.get(Calendar.SECOND));
            try {
                Thread.sleep(1000);
                notifyObserver();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public String getTime() {
        return _time;
    }

    @Override
    public void addObserver(Observer observer) {
        _observer.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        _observer.remove(observer);
    }

    @Override
    public void notifyObserver() {
        _observer.forEach(Observer::update);

    }

    @Override
    public void setNewState() {
        Thread t = new Thread(this);
        t.start();
    }
}