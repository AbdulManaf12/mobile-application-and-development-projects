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
              image: "hasseb_bhai.jpg",
              name: "Muhammad Hasseb",
              description: "My Favourite colleg will touch his ass",
              price: 200000),
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
