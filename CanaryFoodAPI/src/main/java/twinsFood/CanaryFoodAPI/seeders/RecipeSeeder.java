package twinsFood.CanaryFoodAPI.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twinsFood.CanaryFoodAPI.models.Ingredient;
import twinsFood.CanaryFoodAPI.models.Recipe;
import twinsFood.CanaryFoodAPI.models.Review;
import twinsFood.CanaryFoodAPI.repositories.IngredientRepository;
import twinsFood.CanaryFoodAPI.repositories.RecipeRepository;
import twinsFood.CanaryFoodAPI.repositories.ReviewRepository;

@Component
public class RecipeSeeder implements CommandLineRunner {

    @Autowired
    private RecipeRepository rr;
    @Autowired
    private IngredientRepository ir;
    @Autowired
    private ReviewRepository rvr;

    @Override
    public void run(String... args) throws Exception {
        if (ir.findAll().isEmpty()) {
            Ingredient ingredient1 = new Ingredient("Gofio de millo", "Otros", true, true, false, false, false, "1_Gofio_de_millo.jpg");
            ir.save(ingredient1);
            Ingredient ingredient2 = new Ingredient("Huevos", "Otros", true, false, false, false, false, "2_Huevos.jpg");
            ir.save(ingredient2);
            Ingredient ingredient3 = new Ingredient("Claras de huevo", "Otros", true, false, false, false, false, "3_Clara_de_huevo.jpg");
            ir.save(ingredient3);
            Ingredient ingredient4 = new Ingredient("Stevia", "Otros", true, true, false, false, false, "4_Stevia.jpg");
            ir.save(ingredient4);
            Ingredient ingredient5 = new Ingredient("Canela en polvo", "Otros", true, true, false, false, false, "5_Canela_en_polvo.jpeg");
            ir.save(ingredient5);
            Ingredient ingredient6 = new Ingredient("Levadura en polvo", "Otros", true, true, false, false, false, "6_Levadura_en_polvo.jpeg");
            ir.save(ingredient6);
            Ingredient ingredient7 = new Ingredient("Esencia de vainilla", "Otros", true, true, false, false, false, "7_Esencia_de_vainilla.jpg");
            ir.save(ingredient7);
            Ingredient ingredient8 = new Ingredient("Semillas de chia", "Frutos secos", true, true, false, false, false, "8_Semillas_de_chia.jpg");
            ir.save(ingredient8);
            Ingredient ingredient9 = new Ingredient("Leche", "Otros", true, false, false, false, true, "9_Leche.jpg");
            ir.save(ingredient9);
            Ingredient ingredient10 = new Ingredient("Aceite de oliva", "Otros", true, true, false, false, false, "10_Aceite_de_oliva.jpg");
            ir.save(ingredient10);
            Ingredient ingredient11 = new Ingredient("Frambuesas", "Frutas", true, true, false, false, false, "11_Frambuesas.jpg");
            ir.save(ingredient11);
            Ingredient ingredient12 = new Ingredient("Sirope de agave", "Otros", true, true, false, false, false, "12_Sirope_de_agave.jpg");
            ir.save(ingredient12);
            Ingredient ingredient13 = new Ingredient("Papas nuevas", "Verduras", true, true, false, false, false, "13_Papas_nuevas.jpg");
            ir.save(ingredient13);
            Ingredient ingredient14 = new Ingredient("Piñas de millo", "Verduras", true, true, false, false, false, "14_Piña_de_millo.jpg");
            ir.save(ingredient14);
            Ingredient ingredient15 = new Ingredient("Costillas saladas de cerdo", "Carne", false, false, false, false, false, "15_Costillas_saladas_de_cerdo.jpg");
            ir.save(ingredient15);
            Ingredient ingredient16 = new Ingredient("Azafrán", "Otros", true, true, false, false, false, "16_Azafrán.jpg");
            ir.save(ingredient16);
            Ingredient ingredient17 = new Ingredient("Agua", "Otros", true, true, false, false, false, "17_Agua.jpeg");
            ir.save(ingredient17);
            Ingredient ingredient18 = new Ingredient("Sal", "Otros", true, true, false, false, false, "18_Sal.jpg");
            ir.save(ingredient18);
            Ingredient ingredient19 = new Ingredient("Cilantro", "Verduras", true, true, false, false, false, "19_Cilantro.jpg");
            ir.save(ingredient19);
            Ingredient ingredient20 = new Ingredient("Dientes de ajo", "Verduras", true, true, false, false, false, "20_Dientes_de_ajo.jpg");
            ir.save(ingredient20);
            Ingredient ingredient21 = new Ingredient("Comino en grano", "Frutos secos", true, true, false, false, false, "21_Comino_en_grano.jpg");
            ir.save(ingredient21);
            Ingredient ingredient22 = new Ingredient("Vinagre de vino blanco", "Otros", true, true, false, false, false, "22_Vinagre_de_vino_blanco.jpg");
            ir.save(ingredient22);
            Ingredient ingredient23 = new Ingredient("Pimienta", "Otros", true, true, false, false, false, "23_Pimienta.jpg");
            ir.save(ingredient23);
            Ingredient ingredient24 = new Ingredient("Queso fresco", "Otros", true, false, false, false, true, "24_Queso_fresco.png");
            ir.save(ingredient24);
            Ingredient ingredient25 = new Ingredient("Harina", "Otros", true, true, false, true, false, "25_Harina.jpg");
            ir.save(ingredient25);
            Ingredient ingredient26 = new Ingredient("Miel", "Otros", true, true, false, false, false, "26_Miel.jpg");
            ir.save(ingredient26);
            Ingredient ingredient27 = new Ingredient("Azúcar", "Otros", true, true, true, false, false, "27_Azúcar.jpg");
            ir.save(ingredient27);
            Ingredient ingredient28 = new Ingredient("Piel de limón picada", "Frutas", true, true, false, false, false, "28_Piel_de_limón_picada.jpg");
            ir.save(ingredient28);
            Ingredient ingredient29 = new Ingredient("Anís en grano", "Frutos secos", true, true, false, false, false, "29_Anís_en_grano.jpeg");
            ir.save(ingredient29);
            Ingredient ingredient30 = new Ingredient("Mantequilla", "Otros", true, true, false, false, true, "30_Mantequilla.jpg");
            ir.save(ingredient30);
            Ingredient ingredient31 = new Ingredient("Aceite de maíz", "Otros", true, true, false, false, false, "31_Aceite_de_maíz.jpg");
            ir.save(ingredient31);
            Ingredient ingredient32 = new Ingredient("Limón rallado", "Frutas", true, true, false, false, false, "32_Limón_rallado.jpg");
            ir.save(ingredient32);
            Ingredient ingredient33 = new Ingredient("Plátanos de Canarias", "Frutas", true, true, false, false, false, "33_Plátanos_de_Canarias.jpg");
            ir.save(ingredient33);
            Ingredient ingredient34 = new Ingredient("Leche desnatada", "Otros", true, true, false, false, true, "34_Leche_desnatada.jpg");
            ir.save(ingredient34);
            Ingredient ingredient35 = new Ingredient("Crema de cacahuete", "Frutos secos", true, true, false, false, false, "35_Crema_de_cacahuete.jpg");
            ir.save(ingredient35);
        }
        if (!rr.existsByTitle("Tortitas de gofio")) {
            Recipe recipe1 = new Recipe("Tortitas de gofio", "Desayuno", "1.Echar en una batidora un huevo, una clara de huevo, el gofio (⅓ taza), la stevia (2 sobres), la canela (½ cucharadita), la levadura en polvo (1 cucharadita), la esencia de vainilla (1 cucharadita) y las semillas de chía (1 cucharada).\n" +
                    "2.Batir hasta tener mezcla homogénea y sin grumos.\n" +
                    "3.Si la textura es muy espesa, añadir una cucharada de leche y volver a batir, y así ir añadiendo leche tener la textura deseada. La mezcla debe tener consistencia líquida pero no demasiado, de esta forma las tortitas quedarán más esponjosas.\n" +
                    "4.Dejar reposar la mezcla de las tortitas de gofio unos minutos para que adquiera textura y se integren mejor los sabores.\n" +
                    "5.Engrasar con aceite de oliva una sartén pequeña antiadherente.\n" +
                    "6.Calentar la sartén.\n" +
                    "7.Añadir una pequeña parte de la mezcla a la sartén dándole forma redondeada.\n" +
                    "8.Cocinar unos minutos a fuego bajo-medio para que se cocinen bien pero no se quemen.\n" +
                    "9.Cuando empiecen a salirle a las tortitas de gofio ‘agujeritos’ por la parte superior, darle la vuelta y cocinar un minuto más por ese otro lado.\n" +
                    "10.Sacar las tortitas de gofio de la sartén.\n" +
                    "11.Repetir el proceso hasta acabar con la totalidad de la mezcla. Con las cantidades indicadas en la receta me salieron 4 tortitas medianas y bastante ‘gorditas’ y esponjosas.\n" +
                    "12.Una vez todas nuestras tortitas de gofio están cocinadas, servir en un plato y añadir por encima los toppings deseados. En este caso yo he utilizado frambuesas congeladas y sirope de agave.\n", "1_Tortitas_de_gofio.jpg");
            recipe1.getIngredients().add(ir.findByName("Gofio de millo"));
            recipe1.getIngredients().add(ir.findByName("Huevos"));
            recipe1.getIngredients().add(ir.findByName("Claras de huevo"));
            recipe1.getIngredients().add(ir.findByName("Stevia"));
            recipe1.getIngredients().add(ir.findByName("Canela en polvo"));
            recipe1.getIngredients().add(ir.findByName("Levadura en polvo"));
            recipe1.getIngredients().add(ir.findByName("Esencia de vainilla"));
            recipe1.getIngredients().add(ir.findByName("Semillas de chia"));
            recipe1.getIngredients().add(ir.findByName("Leche"));
            recipe1.getIngredients().add(ir.findByName("Aceite de oliva"));
            recipe1.getIngredients().add(ir.findByName("Frambuesas"));
            recipe1.getIngredients().add(ir.findByName("Sirope de agave"));
            rr.save(recipe1);
        }
        if (!rr.existsByTitle("Papas, piñas y costillas")) {
            Recipe recipe2 = new Recipe("Papas, piñas y costillas", "Almuerzo o Cena", "1.Desala las costillas (aprox. 250 g por persona) desde la noche anterior. Déjalas en remojo en abundante agua fría durante unas 12 horas, cambiando el agua 2 o 3 veces para eliminar el exceso de sal. Al día siguiente, comienza Cociendo las dos piñas de millo. En un caldero amplio, añade las piñas partidas por la mitad y cúbrelas con agua hasta la mitad del caldero. Agrega unas hebras de azafrán y pon al fuego. Deja hervir durante 30 minutos.\n" +
                    "2.Añade las costillas desaladas al caldero. Cocina durante otros 30 minutos a fuego medio.\n" +
                    "3.Incorpora las papas (unas 2-3 medianas por persona), peladas y enteras (o partidas si son grandes). Baja el fuego para que no se rompan durante la cocción y deja guisar durante 30–40 minutos, hasta que estén tiernas.\n" +
                    "4.Apaga el fuego y deja reposar el guiso al menos 30 minutos antes de servir. Esto permite que los sabores se integren y el caldo se asiente.\n" +
                    "5.Prepara el mojo de cilantro. Lava bien el cilantro y sécalo. Pela los dos dientes de ajo. En un vaso batidor o mortero, añade el cilantro, el ajo, el comino (½ cucharadita), la sal y el vinagre (2 cucharadas). Tritura todo hasta formar una pasta espesa. Añade poco a poco el aceite de oliva (100 ml) mientras sigues batiendo, hasta que el mojo tenga una textura homogénea y brillante. Prueba y ajusta de sal, vinagre o picante al gusto.", "2_Papas_piñas_y_costillas.jpg");
            recipe2.getIngredients().add(ir.findByName("Papas nuevas"));
            recipe2.getIngredients().add(ir.findByName("Piñas de millo"));
            recipe2.getIngredients().add(ir.findByName("Costillas saladas de cerdo"));
            recipe2.getIngredients().add(ir.findByName("Azafrán"));
            recipe2.getIngredients().add(ir.findByName("Agua"));
            recipe2.getIngredients().add(ir.findByName("Sal"));
            recipe2.getIngredients().add(ir.findByName("Cilantro"));
            recipe2.getIngredients().add(ir.findByName("Dientes de ajo"));
            recipe2.getIngredients().add(ir.findByName("Comino en grano"));
            recipe2.getIngredients().add(ir.findByName("Aceite de oliva"));
            recipe2.getIngredients().add(ir.findByName("Vinagre de vino blanco"));
            recipe2.getIngredients().add(ir.findByName("Pimienta"));
            rr.save(recipe2);
        }
        if (!rr.existsByTitle("Quesadilla herreña")) {
            Recipe recipe3 = new Recipe("Quesadilla herreña", "Postre", "1.Chafar el queso fresco (350 gr) con un tenedor sin mezclarlo o batirlo para que no se haga una pasta compacta.\n" +
                    "2.Mezclar el huevo con el azúcar (35 gr), la miel (50 gr) y la media piel de limón picada.\n" +
                    "3.Añadir el queso fresco machacado y mezclar.\n" +
                    "4.Agregar el anís en grano (½ cucharadita) y la canela en polvo (1 pizca) y mezclar de nuevo.\n" +
                    "5.Añadir la harina (70 gr) y mezclar hasta que se incorpore por completo.\n" +
                    "6.Tapar con papel film y dejar reposar a temperatura ambiente durante 1 hora.\n" +
                    "7.Pasar un trocito de mantequilla por la base y los laterales de los huecos de un molde de muffins.\n" +
                    "8.Verter un poquito de harina dentro cada hueco y por los laterales para que se adhiera a la mantequilla y darle la vuelta al molde de muffins para quitar el exceso de harina.\n" +
                    "9.Rellenar cada hueco con la masa hasta llegar a la mitad.\n" +
                    "10.Hornear a 170ºC durante unos 45 minutos.\n" +
                    "11.Sacar del horno y dejar enfriar a temperatura ambiente.\n" +
                    "12.Desmoldar las quesadillas herreñas y conservarlas en la nevera.\n" +
                    "13.Sacar las quesadillas herreñas de la nevera 30 minutos antes de consumirlas para que se atemperen.\n", "3_Quesadilla_herreña.jpg");
            recipe3.getIngredients().add(ir.findByName("Queso fresco"));
            recipe3.getIngredients().add(ir.findByName("Harina"));
            recipe3.getIngredients().add(ir.findByName("Miel"));
            recipe3.getIngredients().add(ir.findByName("Azúcar"));
            recipe3.getIngredients().add(ir.findByName("Huevos"));
            recipe3.getIngredients().add(ir.findByName("Piel de limón picada"));
            recipe3.getIngredients().add(ir.findByName("Anís en grano"));
            recipe3.getIngredients().add(ir.findByName("Canela en polvo"));
            recipe3.getIngredients().add(ir.findByName("Mantequilla"));
            rr.save(recipe3);
        }
        if (!rr.existsByTitle("Galletas gomeras")) {
            Recipe recipe4 = new Recipe("Galletas gomeras", "Merienda", "1.Cascar los 3 huevos y batirlos con la mantequilla (500 gr) a punto de pomada, añadir el azúcar (1 kg) (dejar un poco para pasar las galletas después de cortadas). Añadir la canela y el limón, la leche (1 vaso), el agua (1 vaso), el aceite (1 l), y mezclar bien.\n" +
                    "2.Por último incorporar la harina (3500 gr) tamizada con levadura (2 sobres), amasar y reposar en nevera por lo menos 20 minutos.\n" +
                    "3.Separamos un poco de masa y extendemos con el rodillo de 1 cm de grosor o un poco menos (no poner harina en la superficie donde extendemos la masa es preferible un papel vegetal). Cortar las galletas con un cortapastas y pasar una de las caras por azúcar ir colocándolas en la vilana.\n" +
                    "4.Hornear con el horno precalentado a 180º hasta que hayan estofado un poco y estén doraditas *Pueden durar bastante tiempo guardadas en botes herméticos o latas para galletas*.\n", "4_Galletas_gomeras.jpg");
            recipe4.getIngredients().add(ir.findByName("Huevos"));
            recipe4.getIngredients().add(ir.findByName("Azúcar"));
            recipe4.getIngredients().add(ir.findByName("Harina"));
            recipe4.getIngredients().add(ir.findByName("Levadura en polvo"));
            recipe4.getIngredients().add(ir.findByName("Mantequilla"));
            recipe4.getIngredients().add(ir.findByName("Leche"));
            recipe4.getIngredients().add(ir.findByName("Agua"));
            recipe4.getIngredients().add(ir.findByName("Canela en polvo"));
            recipe4.getIngredients().add(ir.findByName("Aceite de maíz"));
            recipe4.getIngredients().add(ir.findByName("Limón rallado"));
            rr.save(recipe4);
        }
        if (!rr.existsByTitle("Batido de gofio")) {
            Recipe recipe5 = new Recipe("Batido de gofio", "Bebida", "1.Mezclamos todo (20 gr de gofio, 124 gr de plátano, 200 ml de leche y 23 gr de crema de cacahuete) en una jarra y batimos hasta que todo esté bien integrado.\n" +
                    "2.Lo servimos y a disfrutar!! Si lo queremos en versión papilla (más espeso),tendríamos que echar menos leche.\n", "5_Batido_de_gofio.jpg");
            recipe5.getIngredients().add(ir.findByName("Gofio de millo"));
            recipe5.getIngredients().add(ir.findByName("Plátanos de Canarias"));
            recipe5.getIngredients().add(ir.findByName("Leche desnatada"));
            recipe5.getIngredients().add(ir.findByName("Crema de cacahuete"));
            rr.save(recipe5);
        }
        if (rvr.findAll().isEmpty()) {
            rvr.save(new Review("Prueba1", "Me encanta", 5, rr.findByTitle("Tortitas de gofio")));
            rvr.save(new Review("Prueba2", "No me gusta", 1, rr.findByTitle("Tortitas de gofio")));
            rvr.save(new Review("Prueba3", "Me encanta", 5, rr.findByTitle("Papas, piñas y costillas")));
            rvr.save(new Review("Prueba4", "No me gusta", 1, rr.findByTitle("Papas, piñas y costillas")));
            rvr.save(new Review("Prueba5", "Me encanta", 5, rr.findByTitle("Quesadilla herreña")));
            rvr.save(new Review("Prueba6", "No me gusta", 1, rr.findByTitle("Quesadilla herreña")));
            rvr.save(new Review("Prueba7", "Me encanta", 5, rr.findByTitle("Galletas gomeras")));
            rvr.save(new Review("Prueba8", "No me gusta", 1, rr.findByTitle("Galletas gomeras")));
            rvr.save(new Review("Prueba9", "Me encanta", 5, rr.findByTitle("Batido de gofio")));
            rvr.save(new Review("Prueba10", "No me gusta", 1, rr.findByTitle("Batido de gofio")));
        }
    }
}
