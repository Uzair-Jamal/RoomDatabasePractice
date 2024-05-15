package com.app.roomdatabasepractice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.roomdatabasepractice.model.Subscriber
import com.app.roomdatabasepractice.repository.SubscriberRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository): ViewModel() {

    val inputName = MutableLiveData<String>()
    val inputEmail = MutableLiveData<String>()

    val saveOrUpdateBtnText = MutableLiveData<String>()
    val clearOrDeleteBtnText = MutableLiveData<String>()

    init{
        saveOrUpdateBtnText.value = "Save"
        clearOrDeleteBtnText.value = "Clear All"
    }



    val subscribers = repository.subscribers

    fun insert(subscriber: Subscriber) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.insert(subscriber)
        }

    fun update(subscriber: Subscriber) =
        viewModelScope.launch(Dispatchers.IO) {
            repository.update(subscriber)
        }

    fun delete(subscriber: Subscriber) =
        viewModelScope.launch(Dispatchers.IO){
            repository.delete(subscriber)
        }

    fun clearAll() =
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAll()
    }

    fun saveOrUpdate(){
        val name = inputName.value!!
        val email = inputEmail.value!!
        insert(Subscriber(0,name,email))
        inputName.value = ""
        inputEmail.value = ""
    }

    fun clearAllOrDelete(){
        clearAll()
    }





}