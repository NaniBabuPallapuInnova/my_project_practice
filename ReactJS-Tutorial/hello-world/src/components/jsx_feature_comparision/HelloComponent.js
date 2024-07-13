import React from "react"

/**
 
// With JSX 
function HelloComponent(){
    return <div id='welcome' className='dummyClassName'>
        <h1>Hello Nani Babu</h1>
    </div>
}
 
*/


// Without JSX
function HelloComponent() {
    return React.createElement('div', { id: 'welcome', className: 'dummyClassName' }, React.createElement('h1', null, 'Hello Nani Babu'))
}

export default HelloComponent
