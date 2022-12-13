import 'package:flutter/material.dart';

void main() => runApp(MaterialApp(
    home: Scaffold(
      appBar: AppBar(
        title: const Text("Manaf First Demo"),
        centerTitle: true,
      ),
      body: const Center(
        child: Text('Hello World!'),
      ),
      floatingActionButton: const FloatingActionButton(
        onPressed: null,
        child: Text('Submit'),
      ),
    ),
  ));
