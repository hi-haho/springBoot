package pack;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class mongoTest1 {

	public static void main(String[] args) {
		//Application project : java + mongoDB
		try {
//			 ***MongoDB 연결 URI***
			//방법 1
			//MongoClientURI uri = new MongoClientURI("mongodb://localhost:27017");
			//MongoClient mongoClient = new MongoClient(uri);
			
			//방법 2
			MongoClient client = MongoClients.create("mongodb://localhost:27017");
			
			MongoDatabase db = client.getDatabase("test");
			
			//bson
			MongoCollection<Document> collection = db.getCollection("customer");
			System.out.println("자료 건수 : " + collection.countDocuments());
			
//			한개의 Document 읽기
			Document document = collection.find().first();
			System.out.println("첫번째 자료 : " + document.toJson());
			
//			전체 자료 읽기
			System.out.println("[[ 전체 자료 ]]");
			
			//FindIterable<Document> iter = collection.find();
			//MongoCursor<Document> cursor = iter.iterator();
			// 위의 두줄을 아래 한줄로 표현 가능
			MongoCursor<Document> cursor = collection.find().iterator();
			//limit를 체이닝으로 사용 가능
			//MongoCursor<Document> cursor = collection.find().limit(2).iterator();
			
			while(cursor.hasNext()) {
				//Document doc = cursor.next();
				//String jsonResult = doc.toJson();
				//위의 두 줄을 아래로 줄여 쓴다면
				String jsonResult = cursor.next().toJson();
				System.out.println(jsonResult);
			}
			
			System.out.println("전체 자료 : Field 자료만 출력");
			cursor = collection.find().iterator();
			while(cursor.hasNext()) {
				Document doc2 = cursor.next();
				System.out.println("이름 : " + doc2.get("name") + " 나이 : " + doc2.get("age")+ " 성별 : " + doc2.get("gender"));
			}
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
			collection.find().forEach(printData);
		} catch (Exception e) {
			System.out.println("err : " + e.getMessage());
		}

	}
	
	//Block<Document> 대신 Consumer<Document>를 사용
	static Consumer<Document> printData = new Consumer<Document>() {
		
		@Override
		public void accept(Document t) {
			System.out.println(t.toJson());
		}
	};
}
