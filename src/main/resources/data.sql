-- sample data for Waste Categories
INSERT INTO waste_categories (name, description) VALUES
    ('Plastic', 'All types of plastic materials and products.'),
    ('Organic Waste', 'Waste that can decompose, like food scraps or garden waste.'),
    ('Metal', 'All types of metal waste including cans and foil.');

-- sample data for Disposal Guidelines
INSERT INTO disposal_guidelines (title, instructions, waste_category_id) VALUES
    ('Plastic Recycling Guide', 'Proper disposal methods for plastic waste.', 1),
    ('Organic Waste Disposal Guide', 'Guide for composting and disposing of organic waste.', 2),
    ('Metal Recycling Guide', 'Proper methods for disposing of metal products.', 3);

-- splitting the do and dont list into separate statements because of their @ElementCollection annotation

-- dos list items for Plastic
INSERT INTO dos_list (guideline_id, dos) VALUES
    (1, 'Rinse out containers before recycling.'),
    (1, 'Remove plastic caps and lids.'),
    (1, 'Keep plastics clean and dry.');

-- donts list items for Plastic
INSERT INTO donts_list (guideline_id, donts) VALUES
    (1, 'Don''t include contaminated plastics.'),
    (1, 'Don''t mix with other materials.'),
    (1, 'Don''t recycle plastic bags in curbside bins.');

-- dos list items for Organic Waste
INSERT INTO dos_list (guideline_id, dos) VALUES
    (2, 'Add fruit and vegetable scraps to the compost.'),
    (2, 'Include coffee grounds and eggshells.'),
    (2, 'Shred leaves and branches for quicker decomposition.');

-- donts list items for Organic Waste
INSERT INTO donts_list (guideline_id, donts) VALUES
    (2, 'Don''t include meat or dairy products.'),
    (2, 'Don''t use plastic bags for organic waste.'),
    (2, 'Don''t add diseased plants to compost.');

-- dos list items for Metal 
INSERT INTO dos_list (guideline_id, dos) VALUES
    (3, 'Clean metal cans before recycling.'),
    (3, 'Flatten cans to save space.'),
    (3, 'Separate aluminum from steel.');

-- donts list items for Metal
INSERT INTO donts_list (guideline_id, donts) VALUES
    (3, 'Don''t include metal that is too large.'),
    (3, 'Don''t mix with hazardous waste.'),
    (3, 'Don''t recycle any metal that is not clean.');

-- sample data for Recycling Tips
INSERT INTO recycling_tips (title, description, waste_category_id) VALUES
    ('Plastic Recycling', 'Always check the recycling symbols on plastics to ensure they are recyclable.', 1),
    ('Composting', 'Using a compost bin can significantly reduce the volume of waste sent to landfills.', 2),
    ('Metal Disposal', 'Batteries and certain metals require special disposal methods; check local guidelines.', 3);