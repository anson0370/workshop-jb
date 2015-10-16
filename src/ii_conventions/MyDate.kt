package ii_conventions

import syntax.operatorOverloading.C
import java.util.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    operator override fun compareTo(other: MyDate): Int {
        val self = Calendar.getInstance()
        self.set(year, month, dayOfMonth)
        val target = Calendar.getInstance()
        target.set(other.year, other.month, other.dayOfMonth)
        return self.compareTo(target)
    }

    operator fun rangeTo(other: MyDate): DateRange = DateRange(this, other)

    operator fun plus(interval: TimeInterval) = this.addTimeIntervals(interval, 1)
    operator fun plus(repeatedTimeInterval: RepeatedTimeInterval) =
            this.addTimeIntervals(repeatedTimeInterval.interval, repeatedTimeInterval.time)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(time: Int): RepeatedTimeInterval = RepeatedTimeInterval(this, time)
}

class RepeatedTimeInterval(val interval: TimeInterval, val time: Int)

class DateRange(public override val start: MyDate, public override val end: MyDate) : Iterable<MyDate>, Range<MyDate> {
    override fun contains(item: MyDate): Boolean {
        return this.any { date -> date == item }
    }

    override fun iterator(): Iterator<MyDate> {
        var during = start

        return object : Iterator<MyDate> {
            override fun next(): MyDate {
                val now = during
                during = during.nextDay()
                return now
            }

            override fun hasNext(): Boolean {
                return during <= end
            }

        }
    }

}
