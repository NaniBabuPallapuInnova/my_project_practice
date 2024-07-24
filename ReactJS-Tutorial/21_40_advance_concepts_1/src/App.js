import './App.css';
import EventsExample from './components/events/EventsExample';
import EventsExample2 from './components/events/EventsExample2';
import EventsExample3 from './components/events/EventsExample3';
import FormClassComponent from './components/forms_concept/FormClassComponent';
import FormFunctionComponent from './components/forms_concept/FormFunctionComponent';
import StudentForm from './components/forms_practice_with_css/StudentForm';

function App() {
  return (
    <div className="App">
      <EventsExample />      
      <EventsExample2 employeeList = {data} />
      <EventsExample3 />
      <StudentForm />
      {/* Forms Concepts  */}
      <FormFunctionComponent></FormFunctionComponent>
      <FormClassComponent></FormClassComponent>
      
    </div>
  );
}


const data = [
  {id : 101, name : 'Nani Babu', age : 26},
  {id : 102, name : 'Priyanka', age : 22},
  {id : 103, name : 'Ram', age : 35},
  {id : 104, name : 'Seetha', age : 31}
]

export default App;
