// Define basic arithmetic operations
function add(a, b) {
    return a + b;
}

function subtract(a, b) {
    return a - b;
}

function multiply(a, b) {
    return a * b;
}

function divide(a, b) {
    if (b === 0) {
        return "Error: Division by zero";
    }
    return a / b;
}

// Read input from the command line
process.stdout.write("Enter an expression (e.g., 3 + 2, ensure a space between operand1, the operator, and operand2): ");

process.stdin.on('data', (input) => {
    const expression = input.toString().trim();
    const [operand1, operator, operand2] = expression.split(' ');

    const num1 = parseFloat(operand1);
    const num2 = parseFloat(operand2);

    let result;

    switch (operator) {
        case '+':
            result = add(num1, num2);
            break;
        case '-':
            result = subtract(num1, num2);
            break;
        case '*':
            result = multiply(num1, num2);
            break;
        case '/':
            result = divide(num1, num2);
            break;
        default:
            result = "Invalid operator";
            break;
    }

    console.log(`Result: ${result}`);
    process.stdout.write("Enter another expression (or Ctrl+C to exit): ");
});
