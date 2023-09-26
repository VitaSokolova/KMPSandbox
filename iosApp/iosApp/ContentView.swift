import SwiftUI
import shared

struct ContentView: View {
    @ObservedObject private(set) var viewModel: ViewModel
    
    @State private var userInput: String = ""

    var body: some View {
        VStack {
             TextField("Enter Text", text: $userInput)
                 .padding()
                 .textFieldStyle(RoundedBorderTextFieldStyle())
                 .onChange(of: userInput) { newValue in
                     viewModel.searchForMovie(queryText: userInput)
                 }
             
            List(viewModel.phrases, id: \.self) { phrase in
                Text(phrase)
            }
         }
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView(viewModel: ContentView.ViewModel())
	}
}

extension ContentView {
    class ViewModel: ObservableObject {
        @Published var phrases: [String] = ["Loading..."]
        
        private var repository: MoviesRepository = MoviesRepositoryImpl(httpClient: HttpClientHolder().client)
        
        init() {}
        
        func searchForMovie(queryText: String){
            repository.getSearchResults(query: queryText, completionHandler: { movies, error in
                DispatchQueue.main.async {
                    if let movies = movies {
                        self.phrases = movies.map{$0.title}
                    } else {
                        self.phrases = [error?.localizedDescription ?? "error"]
                    }
                }
            })
        }
    }
}   
