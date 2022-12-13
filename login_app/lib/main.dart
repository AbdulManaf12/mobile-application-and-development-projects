import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  runApp(LoginWidget());
}

class LoginWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
        home: Scaffold(
      appBar: AppBar(
        title: const Text("Login"),
        backgroundColor: Colors.blue,
      ),
      body: Container(
        color: Colors.blueGrey,
        width: 300.0,
        height: 300.0,
        margin: const EdgeInsets.only(left: 100.0, top: 50.0),
        child: Center(
          child: Row(
            children: const [
              Text("Name"),
              TextField(

              ),
            ],
          ),
        ),
      ),
    ));
  }
}
