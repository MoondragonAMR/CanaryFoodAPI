import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Navbar from './components/Navbar';
import Recipes from './pages/Recipes';
import RecipeDetails from './pages/RecipeDetails';
import CreateRecipe from '.pages/CreateRecipe';
import UpdateRecipe from 'pages/UpdateRecipe';
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
          <Route path="/recipes/create" element={<CreateRecipe />} />
          <Route path="/recipes/update/:id" element={<UpdateRecipe />} />
          <Route path="/ingredients/add/:id" element={<AddIngredient />} />
          <Route path="/recipes/review/:id" element={<ReviewRecipe />} />
          <Route path="*" element={<NotFound />} />
        </Routes>
      </div>
    </>
  )
}

export default App
