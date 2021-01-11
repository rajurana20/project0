package com.revature.bankapp

import com.revature.bankapp.cli.UserCli

object Runner extends App{
    println("Hello Bank App");
    var userCli = new UserCli();
    userCli.menu();
}