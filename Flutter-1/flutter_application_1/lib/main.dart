import 'dart:html';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: MyHomePage(),
    );
  }
}

class MyHomePage extends StatelessWidget {
  const MyHomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(title: const Text("Hello World")),
        // ignore: prefer_const_constructors
        body: Card(
            child: Column(children: const [
          ProductBox(
              image: "lana_paul.jpeg",
              name: "Lana Paul",
              description: "Zabardast",
              price: 1000),
          ProductBox(
              image: "jonny_bhai.jpg",
              name: "Johny Sine",
              description:
                  "Steven Wolfe (born December 31, 1978), known professionally as Johnny Sins, is an American pornographic actor, director, and YouTuber.[1][2] Sins is known for his shaved head and muscular physique. He is consistently among the most popular male talent pornography searches",
              price: 300),
          ProductBox(
              image: "lana.jpg",
              name: "Lana Rohdes",
              description:
                  "American podcaster,[1] social-media personality,[2] and former pornographic film actress. Throughout her career she has appeared in publications such as Hustler, Penthouse, and Playboy",
              price: 500),
          ProductBox(
              image: "hasseb_bhai.jpg",
              name: "Muhammad Hasseb",
              description:
                  "My Favourite collegue i like his dick + pussy and one day i will touch his ass",
              price: 200000),
          ProductBox(
              image: "alyx_star.jpg",
              name: "Alyx Star",
              description: "My Favourite PornStar I like her pussy",
              price: 1000),
          ProductBox(
              image: "Manaf.jpg",
              name: "Abdul Manaf",
              description: "Fan of all these beautiful peoples",
              price: 1000)
        ])));
  }
}

class ProductBox extends StatelessWidget {
  const ProductBox(
      {super.key,
      required this.image,
      required this.name,
      required this.description,
      required this.price});

  final String image;
  final String name;
  final String description;
  final double price;

  @override
  Widget build(BuildContext context) {
    return Container(
        padding: const EdgeInsets.all(5),
        height: 120,
        child: Card(
            margin: const EdgeInsets.all(5),
            child: Row(
                mainAxisAlignment: MainAxisAlignment.start,
                crossAxisAlignment: CrossAxisAlignment.center,
                children: [
                  Image.asset(image, height: 100, width: 100),
                  Expanded(  
                      child: Column(
                    children: [
                      Text(
                        name,
                        style: const TextStyle(fontWeight: FontWeight.bold),
                      ),
                      Text(description),
                      Text("$price USD"),
                    ],
                  ))
                ])));
  }
}
