import React from "react"

function FormFunctionComponent(){

    const [fullName, setFullName] = React.useState('');

    const handleValue  = (event) =>{
        setFullName(event.target.value.toUpperCase());
    }

    return (
        <div>
            <h4>Controlled Function Component</h4>
            <form>
                <input type="text" value={fullName} onChange={handleValue} />
                <pre>Entered Value : {fullName}</pre>
            </form>
        </div>
    )
}



export default FormFunctionComponent