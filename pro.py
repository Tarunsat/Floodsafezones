from tkinter import *



root = Tk()

def show():


    import numpy as np
    import joblib
    import matplotlib.pyplot as plt
    import pandas as pd

    dataset = pd.read_csv('daily_weather.csv')
    X = dataset.iloc[:,:-1].values
    Y = dataset.iloc[:,-1].values

    from sklearn.preprocessing import LabelEncoder
    le = LabelEncoder()
    Y = le.fit_transform(Y)

    print(Y)

    from sklearn.model_selection import train_test_split
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size = 0.25, random_state = 0)

    from sklearn.preprocessing import StandardScaler
    sc = StandardScaler()
    X_train = sc.fit_transform(X_train)
    X_test = sc.transform(X_test)

    from sklearn.svm import SVC
    classifier = SVC(kernel='linear', random_state=0)
    classifier.fit(X_train, Y_train)

    joblib.dump(classifier, 'weather.pkl')




    y_pred = classifier.predict(X_test)
    print(np.concatenate((y_pred.reshape(len(y_pred),1), Y_test.reshape(len(Y_test),1)),1))

    from sklearn.metrics import confusion_matrix, accuracy_score
    cm = confusion_matrix(Y_test, y_pred)
    print(cm)
    print(accuracy_score(Y_test, y_pred))

    dataset = pd.read_csv('daily_weather(1).csv')
    X1 = dataset.iloc[:,:-1].values
    Y1 = dataset.iloc[:,-1].values

    from sklearn.preprocessing import LabelEncoder
    le1 = LabelEncoder()
    Y1 = le.fit_transform(Y1)

    from sklearn.preprocessing import StandardScaler
    sc1 = StandardScaler()
    X1 = sc.transform(X1)

    y_pred1 = classifier.predict(X1)
    y_pred1 = le.inverse_transform(y_pred1)
    Y1 = le.inverse_transform(Y1)
    print(y_pred1.reshape(len(y_pred1),1))
    print(accuracy_score(Y1, y_pred1))


button = Button(root, text="click Me", command=show).pack()

root.mainloop()



