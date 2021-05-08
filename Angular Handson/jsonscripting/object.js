var myJson = '{"firstName": "John","lastName": "Stoke","Salary": 5000,"permanentStuff": true,"Department": {"id":3,"name":"Payroll"},"Skills": [{"id":1,"value":"HTML"},{"id":2,"value":"CSS"},{"id":3,"value":"JavaScript"}]}';
var Object = JSON.parse(myJson);
console.log("firstName: "+Object["firstName"]);
console.log("lastName: "+Object["lastName"]);
console.log("Salary: "+Object["Salary"]);
console.log("permanentStuff: "+Object["permanentStuff"]);
console.log("department id: "+Object["Department"]["id"]);
console.log("department name: "+Object["Department"]["name"]);
var iterator;
var counter = 0;
for(iterator of Object["Skills"])
{
	counter += 1;
	console.log("skill "+counter+": "+iterator["id"]+", "+iterator["value"]);
}