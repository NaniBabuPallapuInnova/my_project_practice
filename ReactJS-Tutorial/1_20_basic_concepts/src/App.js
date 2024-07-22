import './App.css';
import React from 'react';
import FuncationalComExample from './components/functional_components/FunctionalComExample';
import ClassComExample from './components/class_components/ClassComExample';
import HelloComponent from './components/jsx_feature_comparision/HelloComponent';
import PropsExample from './components/props_states/PropsExample';
import StatesExample from './components/props_states/StatesExample';
import Counter from './components/props_states/Counter';
import User from './components/conditional_rendering/User';
import FruitsList from './components/lists/FruitsList';
import EmployeeList from './components/lists/EmployeeList';
import StudentList from './components/lists/StudentList';

function App() {
  const data = [
    { id: 1001, name: 'Nani Babu', age: 25, branch: 'CSE' },
    { id: 1002, name: 'Priyanka', age: 23, branch: 'ECE' },
    { id: 1003, name: 'Praneetha', age: 20, branch: 'EEE' },
    { id: 1004, name: 'Tillu', age: 33, branch: 'CIIVL' },
    { id: 1005, name: 'Radhika', age: 31, branch: 'IT' },
]
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
      <User></User>
      <FruitsList></FruitsList>
      <EmployeeList></EmployeeList>
      <StudentList studentList={data} />
    </div>
  );
}


export default App;
