import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: MyHomePage(
        title: "Hello World!!",
      ),
    );
  }
}

class ProductBox extends StatelessWidget {
  ProductBox(
      {Key? key,
        required this.image,
        required this.name,
        required this.description,
        required this.price})
      : super(key: key);

  final String image;
  final String name;
  final String description;
  final double price;

  @override
  Widget build(BuildContext context) {
    return Container(
      padding: const EdgeInsets.all(1),
      height: 120,
      child: Card(
        child: Row(
          mainAxisAlignment: MainAxisAlignment.start,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            Image.asset(image, height: 90, width: 90),
            Expanded(
              child: Column(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Text(
                    name,
                    style: const TextStyle(
                        fontSize: 16, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    description,
                    style: const TextStyle(
                        fontSize: 16, fontWeight: FontWeight.bold),
                  ),
                  Text(
                    price.toString(),
                    style: const TextStyle(
                        fontSize: 16, fontWeight: FontWeight.bold),
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}

class Product {
  Product(
      {required this.image,
        required this.name,
        required this.description,
        required this.price});

  final String image;
  final String name;
  final String description;
  final double price;
}

//****************************************** Third Screen */
class thirdScreen extends StatefulWidget {
  @override
  State<StatefulWidget> createState() => thirdScreen_State();
}

class thirdScreen_State extends State<thirdScreen> {
  bool _check = false;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Third Screen")),
      body: Center(
        child: Checkbox(
            value: _check,
            onChanged: (value) {
              setState(() {
                _check = !_check;
              });
            }),
      ),
    );
  }
}

//*************************************************** Second Screen */
class SecondScreen extends StatelessWidget {
  TextEditingController usernameController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text("Second Screen")),
      body: Column(
        children: [
          InkWell(
            child: TextField(
              controller: usernameController,
              onChanged: (value) {},
              maxLines: null,
              decoration: const InputDecoration(
                prefixIcon: Icon(Icons.person, size: 32),
                hintText: "Username",
                labelText: "Username",
                border: OutlineInputBorder(
                    borderRadius: BorderRadius.all(Radius.circular(5))),
              ),
            ),
            onTap: () {
              Navigator.pop(context);
            },
          ),
          TextButton(
            onPressed: () {
              Navigator.push(context,
                  MaterialPageRoute(builder: (context) => thirdScreen()));
            },
            child: const Text("Click Me"),
          ),
        ],
      ),
    );
  }
}

//******************************************* First Screen */

class MyHomePage extends StatelessWidget {
  MyHomePage({Key? key, required this.title}) : super(key: key);

  final String title;
  List<Product> data = [
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
    Product(
        image: "smiley.png",
        name: "Smiley",
        description: "This is smiley",
        price: 100),
    Product(
        image: "crying.png",
        name: "Crying",
        description: "This is Crying picture",
        price: 80),
  ];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text(title),
      ),
      body: ListView.builder(
        itemCount: data.length,
        itemBuilder: (context, index) => InkWell(
          child: ProductBox(
              image: data[index].image,
              name: data[index].name,
              description: data[index].description,
              price: data[index].price),
          onTap: () {
            //_showDialog(context);
            Navigator.push(
              context,
              MaterialPageRoute(
                builder: (context) => SecondScreen(),
              ),
            );
          },
        ),
      ),
    );
  }

  void _showDialog(BuildContext context) {
    var simpleDialog = SimpleDialog(
      title: const Text("Use Account"),
      children: [
        Container(
          height: 50,
          padding: const EdgeInsets.all(5),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: const [
              Icon(
                Icons.account_circle,
                color: Colors.orange,
                size: 32,
              ),
              Text("nisar@gmail.com", style: TextStyle(fontSize: 24)),
            ],
          ),
        ),
        Container(
          height: 50,
          padding: const EdgeInsets.all(5),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: const [
              Icon(
                Icons.account_circle,
                color: Colors.blue,
                size: 32,
              ),
              Text("azhar123@gmail.com", style: TextStyle(fontSize: 24)),
            ],
          ),
        ),
        Container(
          height: 50,
          padding: const EdgeInsets.all(5),
          child: Row(
            mainAxisAlignment: MainAxisAlignment.start,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: const [
              Icon(
                Icons.add_circle,
                color: Colors.grey,
                size: 32,
              ),
              Text("Add Account", style: TextStyle(fontSize: 24)),
            ],
          ),
        ),
      ],
    );

    showDialog(context: context, builder: (context) => simpleDialog);
  }
}

class MyButton extends StatelessWidget {
  MyButton({Key? key}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: const BoxDecoration(
        border: Border(
          top: BorderSide(width: 1.0, color: Color(0xFFFFFFFFFF)),
          left: BorderSide(width: 1.0, color: Color(0xFFFFFFFFFF)),
          right: BorderSide(width: 1.0, color: Color(0xFFFF000000)),
          bottom: BorderSide(width: 1.0, color: Color(0xFFFF000000)),
        ),
      ),
      child: Container(
        padding: const EdgeInsets.symmetric(horizontal: 20.0, vertical: 2.0),
        decoration: const BoxDecoration(
          border: Border(
            top: BorderSide(width: 1.0, color: Color(0xFFFFDFDFDF)),
            left: BorderSide(width: 1.0, color: Color(0xFFFFDFDFDF)),
            right: BorderSide(width: 1.0, color: Color(0xFFFF7F7F7F)),
            bottom: BorderSide(width: 1.0, color: Color(0xFFFF7F7F7F)),
          ),
          color: Colors.grey,
        ),
        child: const Text(
          "OK",
          textAlign: TextAlign.center,
          style: TextStyle(color: Colors.black),
        ),
      ),
    );
  }
}
