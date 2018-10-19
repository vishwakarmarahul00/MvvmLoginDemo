# MvvmLoginDemo with LiveData Data Binding
This demo basically is using MVVM with LiveData Data Binding.
MVVM was invented by Microsoft architects Ken Cooper and Ted Peters specifically to simplify event-driven programming of user interfaces.
# Android MVVM
MVVM stands for Model, View, ViewModel.

* Model: This holds the data of the application. It cannot directly talk to the View. Generally, it’s recommended to expose the data to the ViewModel through Observables.
* View: It represents the UI of the application devoid of any Application Logic. It observes the ViewModel.
* ViewModel: It acts as a link between the Model and the ViewModel. It’s responsible for transforming the data from the Model. It provides data streams to the View. It also uses hooks or callbacks to update the View. It’ll ask for the data from the Model.
##
This Login Demo is very simple to understand MVVM concept.

First of all we import library in 

  implementation 'android.arch.lifecycle:extensions:1.1.1'
  
    implementation 'com.android.support:design:28.0.0'
    
    and
    
    to enable databindig as 
    
     dataBinding {
     
        enabled = true
        
    }
    
    
    
    
