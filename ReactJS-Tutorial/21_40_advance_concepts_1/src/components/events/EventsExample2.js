/**
 * Passing Parameters Using Events In React
 */

function EventEmployeeNames( props) {

    function handleClick(emp, id) {
        console.log('employee details : '+emp);
        console.log(`removed ${id}`);
    }

    // return <li onClick={handleClick(props.employee.id)}>{props.employee.name}</li>
    // using arrow function
    return (
        <div>
            <br></br><br></br>
            <button onClick={(emp) => handleClick(emp, props.employee.id)}>Remove ID OF {props.employee.name} </button>
            <br></br><br></br>
        </div>

    )

}

function EventsExample2(props) {

    const list = props.employeeList.map((element) => (<EventEmployeeNames key={element.id} employee={element} />))
    return (
        <div>
            {list}
        </div>
    )
}


export default EventsExample2
