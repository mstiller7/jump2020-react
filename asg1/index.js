let readline = require('readline-sync');
console.log("a d o o r");
console.log("p o m e n");
console.log("a g o n y");
console.log("n s l l r");
console.log("s d e w a");
let words = ['door', 'omen', 'agony', 'pan', 'pans', 'dew', 'dog', 'dogs', 'mole'];
let count = words.length;
let tries = 0;

while (count > 0) {
	var response = readline.question("Enter a word you think you see: ");
	if (words.indexOf(response) >= 0) {
		console.log("Good job! There are " + --count + " words left to find.");
		delete words[words.indexOf(response)];
	} else { console.log("Incorrect, try again."); }
	tries++;
}

console.log("You completed the game! It took you " + tries + " attempts.");