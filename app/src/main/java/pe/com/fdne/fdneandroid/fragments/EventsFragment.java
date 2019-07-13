package pe.com.fdne.fdneandroid.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import pe.com.fdne.fdneandroid.R;
import ru.cleverpumpkin.calendar.CalendarDate;
import ru.cleverpumpkin.calendar.CalendarView;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        // Inflate the layout for this fragment
        CalendarView calendarView = (CalendarView)view.findViewById(R.id.calendar_view);
        final Calendar calendar = Calendar.getInstance();

        // Initial date
        CalendarDate initialDate = new CalendarDate(calendar.getTime());

        // Minimum available date
        calendar.set(2019, Calendar.JANUARY, 1);
        CalendarDate minDate = new CalendarDate(calendar.getTime());

        // Maximum available date
        calendar.set(2019, Calendar.DECEMBER, 31);
        CalendarDate maxDate = new CalendarDate(calendar.getTime());

        // List of preselected dates that will be initially selected
        List<CalendarDate> preselectedDates = new ArrayList<>(); //calendarView.getSelectedDates();
        //preselectedDates.add(new CalendarDate(calendar.getTime()));
        //preselectedDates.add(new CalendarDate(calendar.getTime()));

        // The first day of week
        int firstDayOfWeek = java.util.Calendar.MONDAY;
        calendarView.setDatesIndicators(generateEvents(calendar));

        // Set up calendar with all available parameters
        calendarView.setupCalendar(
                initialDate,
                minDate,
                maxDate,
                CalendarView.SelectionMode.NON,
                preselectedDates,
                firstDayOfWeek,
                true
        );

        calendarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        //calendarView.moveToDate(calendar.getTime());

        return view;
    }

    private List<CalendarDateIndicator> generateEvents(Calendar calendar) {
        // Indicators
        Context context = requireContext();
        List<CalendarDateIndicator> indicators = new ArrayList<>();
        calendar.set(2019, Calendar.APRIL, 25);
        indicators.add(new CalendarDateIndicator(new CalendarDate(calendar.getTime()), ContextCompat.getColor(context, R.color.colorPrimary), "CICOS 2019 7"));
        calendar.set(2019, Calendar.APRIL, 26);
        indicators.add(new CalendarDateIndicator(new CalendarDate(calendar.getTime()), ContextCompat.getColor(context, R.color.colorPrimaryDark), "CICOS 2019 7"));
        return indicators;
    }

    class CalendarDateIndicator implements CalendarView.DateIndicator {
        CalendarDate date;
        int color;
        String name;

        public CalendarDateIndicator(CalendarDate date, int color, String name) {
            this.date = date;
            this.color = color;
            this.name = name;
        }

        @Override
        public int getColor() {
            return color;
        }

        @NotNull
        @Override
        public CalendarDate getDate() {
            return date;
        }
    }
}
