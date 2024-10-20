#!/drives/c/Users/Sudharsan/AppData/local/Programs/Python/Python312/ python
import pandas as pd
import os

def get_data_frame(dataset_files, data_path):
    for fileIdx in range(len(dataset_files)):
        curr_path = os.path.join(data_path, dataset_files[fileIdx])
        data = pd.read_csv(curr_path, header=None, encoding='cp1252')
        print(data)

def main():
    dataset_dir = os.path.join(os.getcwd(), 'datasets')
    if ( not os.path.exists(dataset_dir) ):
        print("Dataset Directory doesn't exist.")
    
    dataset_files = os.listdir(dataset_dir)

    get_data_frame(dataset_files, dataset_dir)

    
if __name__ == "__main__":
    main()