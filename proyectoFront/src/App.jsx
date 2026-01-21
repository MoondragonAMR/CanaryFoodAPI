import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Navbar from './components/Navbar';
import Recipes from './pages/Recipes';
import RecipeDetails from './pages/RecipeDetails';
import CreateRecipe from '.pages/CreateRecipe';
import UpdateRecipe from 'pages/UpdateRecipe';
import DeleteRecipe from 'pages/DeleteRecipe';
import AddIngredient from 'pages/AddIngredient';
import ReviewRecipe from 'pages/ReviewRecipe';
import './App.css'

function App() {
  return (
    <>
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/recipes" element={<Recipes />} />
          <Route path="/recipes/:id" element={<RecipeDetails />} />
          <Route path="/recipes/create/:id" element={<CreateRecipe />} />
          <Route path="/recipes/update/:id" element={<UpdateRecipe />} />
          <Route path="/recipes/delete/:id" element={<DeleteRecipe />} />
          <Route path="/ingredients/add" element={<AddIngredient />} />
          <Route path="/recipes/review/:id" element={<ReviewRecipe />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </>
  )
}

export default App
