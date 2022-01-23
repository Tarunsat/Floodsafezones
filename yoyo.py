from firebase import firebase

firebase = firebase.FirebaseApplication("https://floodthing-c588b-default-rtdb.firebaseio.com/", None)
data = {
    'Name': 'Tarun Satish'


}

result = firebase.post('/floodthing-c588b-default-rtdb/customer', data)
print(result)