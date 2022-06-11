package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Animal;
import model.Camera;
import model.Expert;
import model.Prediction;
import model.Role;
import model.Specialization;
import model.Zona;

public class Main {
	MysqlCon connection;
	List<String> usernameList, nameList, surnameList, passList, speciesList, zoneList, recordsList, predictionsList;
	List<Integer> usedHourList;
	
	List<Animal> animalList;
	List<Camera> cameraList;
	List<Expert> expertList;
	List<Prediction> predictionList;
	List<model.Record> recordList;
	List<Role> roleList;
	List<Specialization> specializationList;
	List<Zona> zonesList;


	public Main() {
		connection = new MysqlCon();
		roleList = new ArrayList<>();
		specializationList = new ArrayList<>();
		expertList = new ArrayList<>();
		animalList = new ArrayList<>();		
		predictionList = new ArrayList<>();
		zonesList = new ArrayList<>();
		recordList = new ArrayList<>();
		cameraList = new ArrayList<>();
		usernameList = new ArrayList<>();
		nameList = new ArrayList<>();
		surnameList = new ArrayList<>();
		passList = new ArrayList<>();
		usedHourList = new ArrayList<>();

		
	}

	/*
	 * ************************* * Generar usuarios * *
	 ***************************
	 */


	private void generateExperts() {
		loadExpertFiles();
		createRoles();
		printRoles();
		createSpecializations();
		printSpecializations();
		createExperts();
		printExperts();
	}
	
	
	private void printSpecializations() {
		for(Specialization s : specializationList) {
			System.out.println(s.toString());
			connection.insertSpecialization(s);
		}	
	}

	private void printRoles() {
		for(Role r : roleList) {
			System.out.println(r.toString());
			connection.insertRoles(r);
		}
		
	}

	private void createSpecializations() {
		specializationList.add(new Specialization(0, "Ornithology"));
		specializationList.add(new Specialization(1, "Entomology"));
		specializationList.add(new Specialization(2, "Helmitology"));
		specializationList.add(new Specialization(3, "Herpetology"));
		specializationList.add(new Specialization(4, "Ichthyology"));
		specializationList.add(new Specialization(5, "Theriology"));
		specializationList.add(new Specialization(6, "Botany"));
	}

	private void createRoles() {
		roleList.add(new Role(0, "Admin"));
		roleList.add(new Role(1, "User"));
	}

	private void loadExpertFiles() {
		usernameList = cargarFichero("nick.txt");
		cargarFicheroSplit("name_surname.txt");
		passList = cargarFichero("pass.txt");
	}

	private List<String> cargarFichero(String path) {

		List<String> stringList = new ArrayList<>();
		String linea = null;

		try (BufferedReader in = new BufferedReader(new FileReader("ficheros/" + path))) {
			while ((linea = in.readLine()) != null) {

				if (linea != null) {
					stringList.add(linea);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return stringList;
	}

	private void cargarFicheroSplit(String path) {

		String line = null;

		try (BufferedReader in = new BufferedReader(new FileReader("ficheros/" + path))) {
			while ((line = in.readLine()) != null) {

				if (line != null) {
					String[] value = line.split("[ ]");
					nameList.add(value[0]);
					surnameList.add(value[1]);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void createExperts() {

		int day = (int) (Math.random() * (29 - 1)) + 1;
		int month = (int) (Math.random() * (12 - 1)) + 1;
		int year = (int) (Math.random() * (2021 - 2017)) + 2017;

		LocalDate date = LocalDate.of(year, month, day);
		
		for (int i = 0; i < usernameList.size(); i++) {

			int role = (int)(Math.random() * roleList.size()) + 1;
			int specialization = (int)(Math.random() * specializationList.size()) + 1;
			

			Expert expert = new Expert(i, role, specialization, usernameList.get(i), nameList.get(i), surnameList.get(i), passList.get(i),
					usernameList.get(i)+"@gmail.com", "evern", String.valueOf((int)(Math.random() * 1000000000)),
					String.valueOf((int)(Math.random() * 1000)), date, date);

			expertList.add(expert);
		}
	}

	private void printExperts() {
		for (Expert expert : expertList) {
			System.out.println(expert.toString());
			connection.insertExpert(expert);
		}

	}

	/*
	 * ************************* * Generar Followers * *
	 ***************************
	 */
	
	private void generateAnimals() {
		loadAnimalFiles();
		createAnimals();
		printAnimals();
	}

	private void printAnimals() {
		for (Animal animal: animalList) {
			System.out.println(animal.toString());
			connection.insertAnimals(animal);
		}
		
	}

	private void createAnimals() {
		boolean invasor = false;
		for (int i = 0; i < speciesList.size(); i++) {
			if(Math.random() > 0.5) invasor = true;
			else invasor = false;
			Animal animal = new Animal(i, speciesList.get(i), invasor);
			animalList.add(animal);
		}
		
	}

	private void loadAnimalFiles() {
		speciesList = cargarFichero("species.txt");
		
	}
	
	private void generateZones() {
		loadZoneFiles();
		createZones();
		printZones();
	}

	private void printZones() {
		for(Zona z : zonesList) {
			System.out.println(z.toString());
		
		}
	}

	private void createZones() {
		for (int i = 0; i < zoneList.size(); i++) {
			Zona zone= new Zona(i+1, zoneList.get(i));
			zonesList.add(zone);
		}
	}

	private void loadZoneFiles() {
		zoneList = cargarFichero("zones.txt");
		
	}
	
	private void generateCameras() {
		createCameras();
		printCameras();
	}
	
	private void generatePredictions() {
		createPredictions();
		printPredictions();
	}
	
	private void printPredictions() {
		for(Prediction p: predictionList) {
			System.out.println(p.toString());
			connection.insertPredictionValidada(p);
		}
	}

	private void createPredictions() {
		for (int i = 1; i <= 800; i++) {
			int animal = (int) (Math.random() * animalList.size()) + 1;
			int experto = (int) (Math.random() * expertList.size()) -5;
			if (experto <= 0) experto = 1;
			float confianza = (float) (Math.random() * 100);

			
			
			Prediction prediction = new Prediction(i, animal, "example message", "image path", confianza, experto);
			predictionList.add(prediction);
		}
	}

	private void generateRegisters() {
		createRecords();
		printRecords();
	}
	

	private void printRecords() {
		for(model.Record r: recordList) {
			System.out.println(r.toString());
			
			connection.insertRecord(r);
		}
	}

	private void createRecords() {
		for (int i = 1; i <= 800; i++) {
			int day = (int) (Math.random() * (29 - 1)) + 1;
			int month = (int) (Math.random() * (12 - 1)) + 1;
			int year = (int) (Math.random() * (2021 - 2017)) + 2017;

			LocalDate date = LocalDate.of(year, month, day);
			int numCam = (int) (Math.random() * cameraList.size()) + 1;
			model.Record record = new model.Record("imagePath", date, date, numCam);
			recordList.add(record);
		}
	}

	private void printCameras() {

		for(Camera c: cameraList) {
			System.out.println(c.toString());
			
			connection.insertCamera(c);
		}
	}

	private void createCameras() {
		for(int i = 0; i< 100; i++) {
			int numZona = (int) (Math.random() * zoneList.size()) + 1;
			String nombreZona = null;
			for(Zona z : zonesList) {
				if(z.getNumero_zona() == numZona) nombreZona = z.getNombre_zona();
			}
			Camera camera = new Camera(i,numZona, nombreZona);
			cameraList.add(camera);
		}
	}
	
	private void closeConnection() {
		connection.closeConnection();
		
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.generateExperts(); //experts
		main.generateAnimals(); //animals
		main.generateZones(); // zonas
		main.generateCameras(); //cameras	
		main.generateRegisters(); //registros
		main.generatePredictions(); //predictions
		main.closeConnection();
	}

	

	



}
