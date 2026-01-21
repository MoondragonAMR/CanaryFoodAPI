import { Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import Recipes from './pages/recipes';
import RecipeDetails from './pages/recipeDetails';
import CreateRecipe from '.pages/createRecipe';
import UpdateRecipe from 'pages/updateRecipe';
import DeleteRecipe from 'pages/deleteRecipe';
import AddIngredient from 'pages/addIngredient';
import ReviewRecipe from 'pages/reviewRecipe';
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
