class Greeter{
	greeting: string;
	constructor(message: string)
	{
		this.greeting = message;
	}
	greet(){
		return "Hello" + this.greeting;
	}
}

let greeter: Greeter = new Greeter("world");
/** document.write(`<p> ${greeter.greet()} </p>`); */
document.getElementById("greeting").innerHTML = greeter.greet();