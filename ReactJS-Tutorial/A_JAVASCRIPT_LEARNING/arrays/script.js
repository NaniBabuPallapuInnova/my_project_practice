const numbers = [1,2,3,4,5];
const tens = [];

for(let index =0; index <numbers.length; index++){
    tens.push(numbers[index] * 10);
}
console.log("Array With Numbers after multiply with 10s : "+tens);

const twenties = [];

numbers.forEach(element => {
    twenties.push(element * 20);
})


console.log("Array With Numbers after multiply with 20s : "+twenties);

function check(element){
    return element * 30;
}

// const thirties = numbers.map(function (element){
//     return element * 30;
// })
const thirties = numbers.map(check);

console.log("Array With Numbers after multiply with 30s : "+thirties);

const fourties = numbers.map(element => element * 40);
console.log("Array With Numbers after multiply with 40s : "+fourties);

