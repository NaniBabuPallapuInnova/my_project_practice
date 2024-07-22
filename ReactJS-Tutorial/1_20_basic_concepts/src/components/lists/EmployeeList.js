import React from "react";

/*

function EmployeeList(){
    return (
        <div>
            <br></br>
            {employeeList.map(element => <div><li><b>I am {element.name}. My Age is {element.age}. And My Employee Id is {element.id}</b></li><br></br></div>)}
        </div>
    )
}

*/

//efficient way
function EmployeeList(){
    const employee = employeeList.map(element => <div><li><b>I am {element.name}. My Age is {element.age}. And My Employee Id is {element.id}</b></li><br></br></div>)
    return (
        <div>
            <br></br>
            <h3>Rendering Employee List</h3>
            {employee}
        </div>
    )
}

const employeeList = [
    {id: 1, name : 'Nani', age : 25},
    {id : 2, name : 'Priyanka', age : 23},
    {id : 3, name : 'Praneetha', age : 20},
    {id : 4, name : 'Radhika', age : 30},
    {id : 5, name : 'Tillu', age : 35}
];


export default EmployeeList