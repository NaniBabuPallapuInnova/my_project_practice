import './App.css';
import React from 'react';
import FuncationalComExample from './components/functional_components/FunctionalComExample';
import ClassComExample from './components/class_components/ClassComExample';
import HelloComponent from './components/jsx_feature_comparision/HelloComponent';
import PropsExample from './components/props_states/PropsExample';
import StatesExample from './components/props_states/StatesExample';
import Counter from './components/props_states/Counter';

function App() {
  return (
    <div className="App">
      <FuncationalComExample />
      <ClassComExample />
      <HelloComponent />
      <PropsExample name='Nani' heroName='Super Man'>
        <p> I am the Captain</p>
      </PropsExample>
      <PropsExample name='Priyanka' heroName='Super Woman'>
        <button>Click Here To Know More About Me</button>
      </PropsExample>
      <PropsExample name='Praneetha' heroName='Wonder Woman'></PropsExample>
      <StatesExample></StatesExample>
      <br></br>
      <Counter></Counter>
    </div>
  );
}

export default App;
