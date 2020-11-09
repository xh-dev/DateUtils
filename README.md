# DateUtils
A java date utils library which focusing on intuitive operation to date and datetime.

## Dependency - RC version  
[Link to javadoc](https://apidocs.xethh.me/date-utils/6.0.0.RC9/)
```xml
<dependency>
  <groupId>me.xethh.utils</groupId>
  <artifactId>DateUtils</artifactId>
  <version>6.0.0.RC9</version>
</dependency>
```
## Get start
Below are common operation of creating date, date info viewing, date range, formatting.
```java
//create date of current time
Date dateNow = D.dt().now().asDate();
//create date of 2020-04-21 23:11:08.777 under Japan timezone
System.out.println(dateNow);

Date dateJp = D.dt().now().ymd(2020, APR, 21).hmsms(23, 11, 8, 777).asDate();
//Tue Apr 21 23:11:08 CST 2020
System.out.println(dateJp);

//Modifiable date builder object
DatetimeBuilder db = D.dt().now().ymd(2020, APR, 21).hmsms(23, 11, 8, 777);
System.out.println(db);
// DatetimeBuilder[2020-04-21T23:11:08.777+0800]

//add day
db = db.addDays(3);
System.out.println(db);
// DatetimeBuilder[2020-04-24T23:11:08.777+0800]

// add hour
db = db.addHours(1);
System.out.println(db);
// DatetimeBuilder[2020-04-25T00:11:08.777+0800]

//View the date info wit DateInfo object
DateInfo view = db.view();

//year: 2020
System.out.println("year: "+view.year());
// month: APR
System.out.println("month: "+view.month());
// day: 25
System.out.println("day: "+view.day());
// hour: 0
System.out.println("hour: "+view.hour());
// minute: 11
System.out.println("minute: "+view.min());
// second: 8
System.out.println("second: "+view.second());
// millisecond: 777
System.out.println("millisecond: "+view.ms());

//Date range

//Date range from 2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800
DatetimeRange range = db.rangeTo(db.addDays(4).addHours(4));
//DatetimeRange[2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800]
System.out.println(range);

//Date range from 2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800
range = db.rangeToSelf()
        .editEnd().addDays(4).addHours(4).back();
//DatetimeRange[2019-04-25T00:11:08.777+0800 to 2020-04-29T04:11:08.777+0800]
System.out.println(range);

//Is 2019-04-24T00:11:08.777+0800 in side range: false
System.out.println("Is 2019-04-24T00:11:08.777+0800 in side range: "+range.timeInRange(db.addDays(-1).asDate()));
// Is 2019-04-25T00:11:08.777+0800 in side range: true
System.out.println("Is 2019-04-25T00:11:08.777+0800 in side range: "+range.timeInRange(db.asDate()));
// Is 2019-04-26T00:11:08.777+0800 in side range: true
System.out.println("Is 2019-04-26T00:11:08.777+0800 in side range: "+range.timeInRange(db.addDays(1).asDate()));

//Create SimpleDateFormat of format ISO8601
SimpleDateFormat sdf = DateFormatBuilder.Format.ISO8601.getFormatter();
//2020-04-25T00:11:08.777+0800
System.out.println(sdf.format(db.asDate()));

sdf = D.f()
        .year4Digit().hyphen().month2Digit().hyphen().day2Digit().v1().v1("T")
        .hourInDay24().colon().minute().colon().second().dot().ms().TimeZoneRFC822()
        .build();
// 2020-04-25T00:11:08.777+0800
System.out.println(sdf.format(db.asDate()));

```
