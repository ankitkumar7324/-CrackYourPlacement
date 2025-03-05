class Solution 
{
    public long coloredCells(int n) 
    {
        // Step 1: Initialize a variable to store the total number of colored cells.
        long cells = 0;

        // Step 2: Loop through layers from 1 to n to calculate the number of colored cells.
        for (int i = 1; i <= n; i++) 
        {
            // Step 3: If it's the first layer, set cells to 1.
            if (i == 1)
            {
                cells = 1;
            }
            else
            {
                // Step 4: For subsequent layers, add 4 * (i - 1) new cells.
                cells += (4 * (i - 1)); // Add cells for the current layer
            }
        }

        // Step 5: Return the total number of colored cells after the loop finishes.
        return cells;
    }
}