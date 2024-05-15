package com.example.myproject.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.myproject.models.MyBookings
import com.example.myproject.navigation.ROUTE_MY_BOOKING
import com.example.myproject.navigation.ROUTE_UPDATE_BOOKING

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ProductViewModel(var navController: NavController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isloggedin()) {
            navController.navigate(ROUTE_MY_BOOKING)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }


    fun saveProduct(productFrom: String, productDestination: String, productDeparture: String,productReturndate: String) {
        var id = System.currentTimeMillis().toString()
        var productData = MyBookings(productFrom, productDestination, productDeparture,productReturndate ,id)
        var productRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        productRef.setValue(productData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Saved successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${it.exception!!.message}", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    fun viewProducts(
        product: MutableState<MyBookings>,
        products: SnapshotStateList<MyBookings>
    ): SnapshotStateList<MyBookings> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Products")

        //progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //progress.dismiss()
                products.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(MyBookings::class.java)
                    product.value = value!!
                    products.add(value)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return products
    }



    fun deleteProduct(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_MY_BOOKING)
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
                navController.navigate(ROUTE_UPDATE_BOOKING)
            }
        }
    }

    fun updateProduct(from: String, destination: String, departure: String,returndate:String ,id: String) {
        var updateRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        progress.show()
        var updateData = MyBookings(from, destination, departure,returndate ,id)
        updateRef.setValue(updateData).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

//    fun saveProductWithImage(productName:String, productQuantity:String, productPrice:String, filePath: Uri){
//        var id = System.currentTimeMillis().toString()
//        var storageReference = FirebaseStorage.getInstance().getReference().child("Uploads/$id")
//        progress.show()
//
//        storageReference.putFile(filePath).addOnCompleteListener{
//            progress.dismiss()
//            if (it.isSuccessful){
//                // Proceed to store other data into the db
//                storageReference.downloadUrl.addOnSuccessListener {
//                    var imageUrl = it.toString()
//                    var houseData = Upload(productName,productQuantity,
//                        productPrice,imageUrl,id)
//                    var dbRef = FirebaseDatabase.getInstance()
//                        .getReference().child("Uploads/$id")
//                    dbRef.setValue(houseData)
//                    Toast.makeText(context, "Upload successful", Toast.LENGTH_SHORT).show()
//                    navController.navigate(ROUTE_VIEW_UPLOAD)
//                }
//            }else{
//                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
//            }
//        }
//    }


//    fun viewUploads(upload:MutableState<Upload>, uploads:SnapshotStateList<Upload>): SnapshotStateList<Upload> {
//        var ref = FirebaseDatabase.getInstance().getReference().child("Uploads")
//
//        progress.show()
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                progress.dismiss()
//                uploads.clear()
//                for (snap in snapshot.children){
//                    val value = snap.getValue(Upload::class.java)
//                    upload.value = value!!
//                    uploads.add(value)
//                }
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//        return uploads
//    }
}