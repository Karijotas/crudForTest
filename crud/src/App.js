import './App.css';
import { Segmented } from 'antd';
import MealCards from './components/cards';


function App() {
  return (
    <div className="App">
      <header className="App-header">
        Menu
        <Segmented
          className='menu'
          options={[
            'Breakfast',
            'Lunch',
            'Snacks',
            'Desserts',
            'Drinks',
          ]} />
      </header>
      <div className='ops'>
        <MealCards />
      </div>
    </div>
  );
}

export default App;
