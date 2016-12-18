package com.androidproject.netadmin.netadmin.model;

/**
 * Created by Anna Kopeliovich on 18.12.2016.
 */

public enum Color {

//    Компьютер в сети, все возможные изменения успешно выполнены
    GOOD,

//    Компьютер не сети
    BAD,

//    Ожидаем обновления либо выполнения операции
    WAIT,

//    Операция прервана, либо не смогла выполниться
    FAIL
}