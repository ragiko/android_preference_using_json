#概要
preferenceにjsonのデータ形式で入出力  

#詳細
##Save to preference 
* 保存したいオブジェクトのリストをJSON形式でString型にする
* String型をPreferenceで保存
##Get from preference
保存したオブジェクトのリストを取得する 

##参考URL
(preference)
http://androidhacker.blog94.fc2.com/blog-entry-88.html

(json : gson)
http://stackoverflow.com/questions/5554217/google-gson-deserialize-listclass-object-generic-type
http://stackoverflow.com/questions/14258640/hash-map-array-list-to-json-array-in-android

#備考
プリファレンスの場所: /data/data/パッケージ名/shared_prefs
