
function PropsExample(props){
    return <div>
        <h2>My Name is {props.name} and I am the {props.heroName}</h2>
        <h4>{props.children}</h4>
    </div>
}

/*

//destructring above code -1

const PropsExample = props  =>{
    const {name, heroName} = props;
    return (
        <div>
            <h3> My Name is {name} and I am the {heroName}</h3>
        </div>  
    )
}

*/


/*

//destructring above code - 2

const PropsExample = ({name, heroName})  =>{
    return (
        <div>
            <h3> My Name is {name} and I am the {heroName}</h3>
        </div>  
    )
}

*/

export default PropsExample