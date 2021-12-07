package com.fges.commandes.commandes.menu;

public interface IMenu  {
    Menu findMenuById(Long id) throws MenuNotFoundException;
}
