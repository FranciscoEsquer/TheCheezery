package esquer.francisco.thecheezery

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView

class ProductosActivity : AppCompatActivity() {

    var coldDrinks = ArrayList<Product>()
    var hotDrinks = ArrayList<Product>()
    var sweets = ArrayList<Product>()
    var salties = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)

        var productType: Int = intent.getIntExtra("type", 1)

        addProducts(productType)

        var image: ImageView = findViewById(R.id.image_product_type)
        var finalList: ArrayList<Product> = ArrayList()

        when (productType) {
            1 -> {
                finalList = coldDrinks
                image.setImageResource(R.drawable.colddrinks)
            }
            2 -> {
                finalList = hotDrinks
                image.setImageResource(R.drawable.hotdrinks)
            }
            3 -> {
                finalList = sweets
                image.setImageResource(R.drawable.sweets)
            }
            4 -> {
                finalList = salties
                image.setImageResource(R.drawable.salties)
            }
        }

        var listView: ListView = findViewById(R.id.listaproductos)
        var adapter: AdaptadorProductos = AdaptadorProductos(this, finalList)

        listView.adapter = adapter

    }

    fun addProducts(type: Int) {
        when(type) {
            1 -> {
                coldDrinks.add(Product("Caramel Frap", R.drawable.caramelfrap, "Caramel syrup meets coffee, milk and ice and whipped cream and buttery caramel sauce layer the love on top.", 5.00))
                coldDrinks.add(Product("Chocolate Frap", R.drawable.chocolatefrap, "Rich mocha-flavored sauce meets up with chocolaty chips, milk and ice for a blender bash.", 6.00))
                coldDrinks.add(Product("Cold Brew", R.drawable.coldbrew, "Created by steeping medium-to-coarse ground coffee in room temperature water for 12 hours or longer.", 3.00))
                coldDrinks.add(Product("Matcha Latte", R.drawable.matcha, "Leafy taste of matcha green tea powder with creamy milk and a little sugar for a flavor balance that will leave you feeling ready and raring to go.", 4.00))
                coldDrinks.add(Product("Oreo Milkshake", R.drawable.oreomilkshake, "Chocolate ice cream, and oreo cookies. Topped with whipped cream with cocoa and chocolate syrup.", 7.00))
                coldDrinks.add(Product("Peanut Milkshake", R.drawable.peanutmilkshake, "Vanilla ice cream, mixed with peanut butter and chocolate.", 7.00))
            }

            2 -> {
                hotDrinks.add(Product("Latte", R.drawable.latte, "Coffee drink made with espresso and steamed milk.", 6.00))
                hotDrinks.add(Product("Hot chocolate", R.drawable.hotchocolate, "Heated drink consisting of shaved chocolate, topped with marshmallows.", 5.00))
                hotDrinks.add(Product("Espresso", R.drawable.espresso, "Full-flavored, concentrated form of coffee.", 4.00))
                hotDrinks.add(Product("Chai Latte", R.drawable.chailatte, "Spiced tea concentrate with milk.", 6.00))
                hotDrinks.add(Product("Capuccino", R.drawable.capuccino, "A cappuccino is an espresso-based coffee drink, prepared with steamed foam.", 7.00))
                hotDrinks.add(Product("American coffee", R.drawable.americano, "Espresso with hot water.", 2.00))
            }

            3 -> {
                sweets.add(Product("Blueberry cake", R.drawable.blueberrycake, "Vanilla cake flavor, topped with cheese topping and blueberries.", 6.00))
                sweets.add(Product("Chocolate cupcake", R.drawable.chocolatecupcake, "Chocolate cupcakes topped with butter cream and cherries.", 3.00))
                sweets.add(Product("Lemon tartalette", R.drawable.lemontartalette, "Pastry shell with a lemon flavored filling.", 4.00))
                sweets.add(Product("Red Velvet cake", R.drawable.redvelvetcake, "Soft, moist, buttery cake topped with an easy cream cheese frosting.", 6.00))
                sweets.add(Product("Cherry cheesecake", R.drawable. strawberrycheesecake, "This cherry topped cheesecake is positively creamy and delicious and will be your new favorite dessert.", 7.00))
                sweets.add(Product("Tiramisu", R.drawable.tiramisu, "Coffee-flavored Italian dessert.", 6.00))
            }

            4 -> {
                salties.add(Product("Chicken crepes", R.drawable.chickencrepes, "Fine crepes stuffed with Alfredo chicken, spinach and mushrooms.", 6.00))
                salties.add(Product("Club Sandwich", R.drawable.clubsandwich, "A delicious sandwich served with french fries.", 5.00))
                salties.add(Product("Panini", R.drawable.hampanini, "Sandwich made with Italian bread served warmed by grilling.", 4.00))
                salties.add(Product("Philly cheese steak", R.drawable. phillycheesesteak, "Smothered in grilled  onions, green peppers, mushrooms, and Provolone.", 6.00))
                salties.add(Product("Nachos", R.drawable. nachos, "Tortilla chips layered with beef and melted  cheddar cheese. Served with fried beans, guacamole, pico de gallo, and sour topping.", 7.00))
            }

        }
    }

    private class AdaptadorProductos: BaseAdapter {

        var products = ArrayList<Product>()
        var context: Context? = null

        constructor(context: Context, products: ArrayList<Product>) {
            this.context = context
            this.products = products
        }

        override fun getCount(): Int {
            return products.size
        }

        override fun getItem(p0: Int): Any {
            return products[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

            var prod = products[p0]
            var inflator = LayoutInflater.from(context)
            var view = inflator.inflate(R.layout.producto_view, null)

            var image = view.findViewById(R.id.productoimg) as ImageView
            var name = view.findViewById(R.id.productonombre) as TextView
            var desc = view.findViewById(R.id.productodesc) as TextView
            var price = view.findViewById(R.id.productoprecio) as TextView

            image.setImageResource(prod.image)
            name.setText(prod.name)
            desc.setText(prod.description)
            price.setText("$${prod.price}")

            return view

        }

    }

}