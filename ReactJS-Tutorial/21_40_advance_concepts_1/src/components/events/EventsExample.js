function EventsExample(){
    return (
        <div>
            <button onClick={clickMe}>Click</button>
        </div>
    )
}

function clickMe(){
    // console.log("I am clicked in console ");
    // return null;
    alert("I am clicked in console ");
}

export default EventsExample