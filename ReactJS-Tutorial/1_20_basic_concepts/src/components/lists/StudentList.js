import React from 'react';

function StudentNames(props){
    return (
        <div>
            {props.names}
        </div>
    )
}

function StudentList(props) {
    // const list = props.studentList.map((element) => <li key={element.id}>{element.name}, {element.age},{element.branch}</li>);

    const list = props.studentList.map((element) => (
        <StudentNames key={element.id} names={element.name} ages={element.age} branches={element.branch} />

    ))
    return (
        <div>
            {list}
        </div>
    )
}

// this student list data is passing from App.js to StudentList.js file with help of props
// const data = [
//     { id: 1001, name: 'Nani Babu', age: 25, branch: 'CSE' },
//     { id: 1002, name: 'Priyanka', age: 23, branch: 'ECE' },
//     { id: 1003, name: 'Praneetha', age: 20, branch: 'EEE' },
//     { id: 1004, name: 'Tillu', age: 33, branch: 'CIIVL' },
//     { id: 1005, name: 'Radhika', age: 31, branch: 'IT' },
// ]


export default StudentList