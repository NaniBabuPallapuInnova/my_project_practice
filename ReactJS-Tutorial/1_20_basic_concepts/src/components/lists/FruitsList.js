import React from "react";

function FruitsList(){

    return (
        <div>
            <br></br>
            <br></br>
            <h3>Rendering Fruit List </h3>
        {fruits.map(element => <li>{element.id}</li>)},
        {fruits.map(element => <li>{element.name}</li>)}
        </div>
    )
}

/*
function FruitsList(){
    const idList = fruits.map(element => <li>{element.id}</li>)
    const nameList = fruits.map(element => <li>{element.name}</li>)
    return (
        <div>
        {idList} {nameList}
        </div>
    )
}

*/
const fruits = [
    {id : 1, name : 'Apple'},
    {id : 2, name : 'Orange'},
    {id : 3, name : 'Banana'},
    {id : 4, name : 'Cherry'},
    {id : 5, name : 'Lemon'}
];


export default FruitsList