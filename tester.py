import numpy as np
import joblib
import matplotlib.pyplot as plt
import pandas as pd


def city():
    knn_from_joblib = joblib.load('weather.pkl')

    dataset = pd.read_csv('daily_weather(1).csv')
    X1 = dataset.iloc[:, :-1].values
    Y1 = dataset.iloc[:, -1].values

    from sklearn.preprocessing import LabelEncoder
    le = LabelEncoder()
    Y1 = le.fit_transform(Y1)

    from sklearn.preprocessing import StandardScaler
    sc = StandardScaler()
    X1 = sc.fit_transform(X1)
    X1 = sc.transform(X1)

    y_pred1 = knn_from_joblib.predict(X1)
    y_pred1 = le.inverse_transform(y_pred1)
    Y1 = le.inverse_transform(Y1)

    from sklearn.metrics import confusion_matrix, accuracy_score
    a = print(y_pred1.reshape(len(y_pred1), 1))
    return a

city()
