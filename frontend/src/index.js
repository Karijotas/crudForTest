import React from 'react';
import * as ReactDOM from "react-dom";
import { HashRouter, Route, Routes } from "react-router-dom";

import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import DenseTable from './List';
import ResponsiveAppBar from './ResponsiveAppBar';
import FormPropsTextFields from './Create';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
    <HashRouter >
      <Routes>
      <Route path='/' element={<ResponsiveAppBar />} />
      <Route path='/list' element={<DenseTable/>}/>
      <Route path='/create' element={<FormPropsTextFields/>}/>

      </Routes>
    </HashRouter>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
