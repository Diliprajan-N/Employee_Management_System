
import './App.css'
import FooterComponent from './component/FooterComponent.jsx'
import HeaderComponent from './component/HeaderComponent.jsx'
import ListEmployeeComponent from './component/ListEmployeeComponent.jsx'
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import EmployeeComponent from './component/EmployeeComponent.jsx';




function App() {
 

  return (
    <>
    <BrowserRouter>
      <HeaderComponent />
      <Routes>
        {/* //http://localhost:3000 */}
       <Route path='/' element = {<ListEmployeeComponent />}></Route>

       {/* //http://localhost:3000/employees */}
       <Route path='/employees' element = {<ListEmployeeComponent />}></Route>

       {/* //http://localhost:3000/add-employee */}
        <Route path='/add-employee' element = {<EmployeeComponent />}></Route>
        
        {/* //http://localhost:3000/update-employee */}
        <Route path='/update-employee/:id' element = { <EmployeeComponent />}></Route>
       </Routes>

      <FooterComponent />
      </BrowserRouter>
      
  
    </>
  )
}

export default App
