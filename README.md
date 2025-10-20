What was originally going to be a way to abstract the details of JDBC classes away quickly became far to general to be at all useful. Essentially, in trying to make an API that was good all the time I made an API that was good none of the time. I never even bothered publishing these changes onto GitHub because of this. My precise intention for this project was to make an API that made it so I wouldn't have to worry about classes like ResultSet or Statement and could instead work with something simpler like an array or array list. Fortunately, I learned enough about JDBC classes to not really need an application like this anyways. I'm keeping this "project" up as a place to host some basic notes about ResultSet and Statement for myself to refer to at any point if necessary (although it's just my paraphrasing of the actual documentation). 

<h2>Statement</h2>

The Statement class is primarily used to execute an SQL statement and return a ResultSet object. There are a few methods I deem important enough to give spotlight below:

<h3>executeUpdate</h3>
When working with SQL we typically think about making our basic CRUD methods. Execute update handles all of that except the read part of CRUD. You could say that this is the CUD method. This method is also used for SQL statements that return nothing. It takes a String as parameter (the String likely being an SQL statement) and returns an integer. The integer is the number of rows affected (0 in the case of SQL statements that return nothing).

<h3>executeQuery</h3>
The same as executeUpdate, but it handles the read part of CRUD. So if executeUpdate was the CUD method, then this would be the R method. This returns a ResultSet always; even if nothing is found. As such, it never returns null.

<h3>close</h3>
Releases the JDBC and database resources that the statement was taking up immediately. These are automatically released later, but it is considered a major social faux pas to not close at your earliest convenience.
<h3>Other notes</h3>
Only one ResultSet object may be open per Statement. If you want another ResultSet object, you'll need another Statement.

<h2>ResultSet</h2>
The annoying one. Well, it's annoying if you don't know what you're doing with it. It's a little bizarre expecting to recieve like an array from executing a query and then another random object shows up. Basically, ResultSet, as the name implies, represents a table of data as a result from your query. Much like the table it originates from, it has rows, columns, and column names. A cursor indicates what row you are pointing at, but the cursor starts by pointing at no row. 

<h3>next</h3>
Moves the cursor to the, get this, next row. I mentioned that the cursor starts by pointing at no row, and to get it to point towards the first row you have to use this first. This method returns a boolean so while loops are applicable when using ResultSet.

<h3>Getters</h3>
Where next is used to move us between rows, there are various getters that allow us to grab information from a column. Methods like getInt, getLong, getBoolean, etc. These all function mostly the same. They're all overloaded, meaning you can either pass an integer for the column index or String for the column name. 
